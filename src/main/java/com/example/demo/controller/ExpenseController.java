package com.example.demo.controller;

import com.example.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/expenses")
    public String showExpenseList(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpense());
        return "expense-list";
    }
}
