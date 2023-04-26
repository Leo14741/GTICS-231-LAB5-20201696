package com.example.gtics231lab520201696.Controller;

import com.example.gtics231lab520201696.Entitys.Employee;
import com.example.gtics231lab520201696.Repository.EmployeeRepository;
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

    public RecursosController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}
