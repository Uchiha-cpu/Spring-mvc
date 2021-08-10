package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	@RequestMapping(path="/home",method=RequestMethod.GET)//handler method
	public String home(Model model)
	{
		System.out.println("This is home url");
		model.addAttribute("name","Dipesh");
		model.addAttribute("id",1421);
		
		List<String> friends=new ArrayList<String>();
		friends.add("Sarvesh");
		friends.add("Biswesh");
		friends.add("Abhay");
		friends.add("Uttam");
		model.addAttribute("f",friends);
		
		return "index";
	}
	@RequestMapping("/")
	public String about()
	{
		System.out.println("This is about url");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help()
	{
		System.out.println("This is help url");
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("name","Dipesh");
		modelandview.addObject("rollnumber",12);
		LocalDateTime now=LocalDateTime.now();
		modelandview.addObject("time",now);
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(3434);
		list.add(2134);
		list.add(900);
		modelandview.addObject("marks",list);
		modelandview.setViewName("help");
		return modelandview;
	}
}
