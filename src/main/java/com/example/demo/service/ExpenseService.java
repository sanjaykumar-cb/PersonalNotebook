package com.example.demo.service;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.entity.Expense;
import com.example.demo.repo.ExpenseRepo;
import com.example.demo.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final  ExpenseRepo expenseRepo;
    private  final ModelMapper modelMapper;

    public List<ExpenseDTO> getAllExpense() {
        List<Expense> list = expenseRepo.findAll();
        List<ExpenseDTO> expenseList = list.stream().map(this::mapToDTO).collect(Collectors.toList());
        return expenseList;

    }
    private ExpenseDTO mapToDTO(Expense expense) {
       ExpenseDTO expenseDTO = modelMapper.map(expense,ExpenseDTO.class);
       expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
       return expenseDTO;
    }
}
