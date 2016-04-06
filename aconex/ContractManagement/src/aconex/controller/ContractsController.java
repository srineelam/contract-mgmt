package aconex.controller;

import java.math.BigInteger;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aconex.entities.Contract;
import aconex.service.ContractsService;

@Controller
public class ContractsController {
	
	@Autowired
	ContractsService service;
	
	private final Validator validator;
	
	public ContractsController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
	}
	
	@RequestMapping(value = "/contracts", method = RequestMethod.GET)
	public String getContracts(Model model)
	{
		model.addAttribute("contracts", service.getContracts(BigInteger.ONE));
		return "contracts";
	}
	
	@RequestMapping(value = { "/contracts/{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, ModelMap model) {
        Contract contract = service.findContractById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("edit", true);
        return "edit";
    }
	
	@RequestMapping(value = { "/contracts/{id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid Contract contract, BindingResult result,
            ModelMap model, @PathVariable Integer id) {
		 Set<ConstraintViolation<Contract>> violations = validator.validate(contract);
         
	        for (ConstraintViolation<Contract> violation : violations) 
	        {
	            String propertyPath = violation.getPropertyPath().toString();
	            String message = violation.getMessage();
	            // Add JSR-303 errors to BindingResult
	            // This allows Spring to display them in view via a FieldError
	            result.addError(new FieldError("contract", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
	        }
        if (result.hasErrors()) {
            return "edit";
        }
        service.update(contract);
 
        model.addAttribute("contracts", service.getContracts(BigInteger.ONE));
		return "contracts";
    }
	
}
