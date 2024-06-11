package taranova.spring.mvc_hibernate_aop.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taranova.spring.mvc_hibernate_aop.entity.Employee;
import taranova.spring.mvc_hibernate_aop.services.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Setter
@Getter
public class MyController {

    private EmployeeService employeeService;

    public MyController() {
        this.employeeService = new EmployeeService();
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEntities();
        System.out.println(allEmployees);
        model.addAttribute("allEmplo", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-info";
        } else {
        employeeService.saveEntity(employee);
        return "redirect:/";}
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.findEntityById(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteEmployee(@RequestParam("empId")int id) {
        Employee employee = employeeService.findEntityById(id);
        employeeService.deleteEntity(employee);
        return "redirect:/";
    }
}