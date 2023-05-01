package com.example.gtics231lab520201696.Controller;

import com.example.gtics231lab520201696.Entitys.Employee;
import com.example.gtics231lab520201696.Repository.EmployeeRepository;
import com.example.gtics231lab520201696.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recursoshumanos")
public class RecursosController {
    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;

    public RecursosController(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @RequestMapping(value = {"/empleados"},method = RequestMethod.GET)
    public String empleados(Model model){
        List<Employee> listaEmpleados= employeeRepository.findAll();
        model.addAttribute("empleadosList", listaEmpleados);
        return "recursoshumanos/empleados";
    }
    @GetMapping("/empleados/delete")
    public String borrarEmpleado(Model model,
                                   @RequestParam("id") int id,
                                   RedirectAttributes attr) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        return "redirect:/recursoshumanos/empleados";
    }
    @GetMapping("/edit")
    public String editarEmpleado(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "recursoshumanos/editFrm";
        } else {
            return "redirect:/recursoshumanos/empleados";
        }
    }
    @GetMapping("/new")
    public String nuevoEmployee(Model model) {
        model.addAttribute("listaPuestos", jobRepository.findAll());
        model.addAttribute("listaEmployees", employeeRepository.findAll());
        return "recursoshumanos/newFrm";
    }
}
