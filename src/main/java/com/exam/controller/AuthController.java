package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.exam;
import com.exam.repository.examRepository;
import com.exam.services.UserService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    examRepository examrepo;
//    private User user;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "auth/login";
    }




    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String MysqlxDatatypesregister(Model model) {
        model.addAttribute("user",new User());
        return "auth/register";}


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(Model model, @RequestParam String fname,
 @RequestParam String lname,@RequestParam String pnumber,@RequestParam String email,
@RequestParam String password,@RequestParam Role role) throws ParseException {
    User user=new User();
    user.setPassword(password);
    user.setEmail(email);
    user.setFirstName(fname);
    user.setMobile(pnumber);
    user.setRole(role);
    user.setLastName(lname);
    userService.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/saveexam")
    public String saveexam(@RequestParam int id,@RequestParam String examName,
                           @RequestParam String tname,@RequestParam String duration,
                           @RequestParam String data) throws ParseException {Date date=new SimpleDateFormat("yyyy-MM-dd").parse(data);
        exam ex = new exam(id,examName,tname,duration,date);
        examrepo.save(ex);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String getAllexam(Model model)
    {
        List<exam> examList = examrepo.findAll();
        model.addAttribute("examList",examList);
        return "/admin/ViewData";
    }

    @GetMapping("/exam")
    public String exam(Model model){
        return "admin/aexam";
    }

    @GetMapping("/all/{exam}/delete")
    public String getAllexam(@PathVariable("exam") int exam_id)
    {
        examrepo.deleteById(exam_id);
        return "redirect:/all";
    }

    @GetMapping("/")
    public String home(Model model){
        return "HOME";
    }


}

