package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header","Spring MVC");
		m.addAttribute("Desc","Home for Spring Learner");
	}

	@RequestMapping("/contact")
	public String showForm(Model m) {
		/*m.addAttribute("Header","Spring MVC");
		m.addAttribute("Desc","Home for Spring Learner");*/
		return "contact";
	}

	/*
	 * @RequestMapping(path="/processform",method=RequestMethod.POST) 
	 * public String handleForm(
	 * 
	 * @RequestParam(name="email",required=false) String userEmail,
	 * 
	 * @RequestParam("userName") String userName,
	 * 
	 * @RequestParam("password") String userPassword,Model model) {
	 * 
	 * System.out.println("useremail "+userEmail);
	 * System.out.println("username "+userName);
	 * System.out.println("userpassword "+userPassword);
	 * 
	 * User user=new User(); user.setEmail(userEmail); 
	 * user.setUserName(userName);
	 * user.setPassword(userPassword);
	 * 
	 * System.out.println(user);
	 * 
	 * 
	 * model.addAttribute("email",userEmail); 
	 * model.addAttribute("name",userName);
	 * model.addAttribute("password",userPassword);
	 * 
	 * model.addAttribute("user",user); 
	 * return "success"; }
	 */
	@RequestMapping(path="/processform",method=RequestMethod.POST)
	public String handleForm(@ModelAttribute("user") User user,Model model)
	{
		System.out.println(user);
	  /*model.addAttribute("Header","Spring MVC");
		model.addAttribute("Desc","Home for Spring Learner");*/
		this.userService.createUser(user);
		return "success";
	}

}
