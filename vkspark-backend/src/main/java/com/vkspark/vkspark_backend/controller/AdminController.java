package com.vkspark.vkspark_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vkspark.vkspark_backend.dto.DashboardResponse;
import com.vkspark.vkspark_backend.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {

        return adminService.getDashboard();

    }

}
