package pl.wroc.pwr.ankieta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wroc.pwr.ankieta.entity.EmployeeType;
import pl.wroc.pwr.ankieta.service.EmployeeService;

@Controller
@RequestMapping("/workspace")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/addDeveloper")
    @ResponseBody
    public String addDeveloper(@RequestParam String name, @RequestParam String surname) {
        return String.valueOf(employeeService.save(name, surname, EmployeeType.DEVELOPER));
    }
    
    @RequestMapping("/addTester")
    @ResponseBody
    public String addTester(@RequestParam String name, @RequestParam String surname) {
        return String.valueOf(employeeService.save(name, surname, EmployeeType.TESTER));
    }
    
    @RequestMapping("/removeEmployee")
    @ResponseBody
    public String removeEmployee(@RequestParam Integer id) {
        employeeService.delete(id);
        return "true";
    }
}
