package com.example.TransactionalOutBoxPattern.controller;

import com.example.TransactionalOutBoxPattern.dto.Department;
import com.example.TransactionalOutBoxPattern.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Return값으로 @RequestBody에서 넘겨받은 파라미터 값을 출력한다.
     * JSON 형식 요청 데이터를 자바 객체러 변환 → @RequestBody
     *
     * POST 및 PUT 방식 사용시 id=MGR&name=management 형태를 사용하지 않고,
     * 아래의 JSON 형식으로 요청한다. 클라이언트 → 서버 요청시!
     *
     * {
     *     "department_id":"MGR",
     *     "department_name":"management"
     * }
     *
     * @param department
     * @return
     */
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    /**
     * @ResponseBody 어노테이션을 통해서 Get 요청에 대한 응답을 JSON 형태로 반환한다. 서버 → 클라이언트 응답시!
     *
     * [
     *     {
     *         "department_id": "MGR",
     *         "department_name": "management"
     *     },
     *     {
     *         "department_id": "MGR",
     *         "department_name": "management"
     *     }
     * ]
     *
     * @param department_id
     * @return
     */

    @GetMapping("/{department_id}")
    public @ResponseBody List<Department> getDepartment(@PathVariable String department_id) {
        return departmentService.getDepartment(department_id);
    }

}