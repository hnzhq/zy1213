package com.situ.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.model.Depart;
import com.situ.model.Staff;
import com.situ.model.StaffSearchBean;
import com.situ.service.DepartService;
import com.situ.service.StaffService;

/**
 * 商品模块控制器
 * 
 * @author shenming
 *
 */
@Controller
@RequestMapping("/staff/")
public class StaffController {
	// 自动按类型匹配
	@Autowired
	private StaffService service;
	@Autowired
	private DepartService ds;

	@RequestMapping("list")
	public String list(Map<String, Object> map, Integer pageNo, Integer pageSize, StaffSearchBean ssb) {
		// PaginateInfo pi = new PaginateInfo(pageNo, pageSize);

		// 覆盖
		/*if (pageNo != null) {
			pi.setPageNo(pageNo);
		} else {
			pi.setPageSize(pageSize);
		}*/
		// 使用mybatis的分页插件进行分页
		PageHelper.startPage(pageNo == null ? 1 : pageNo, pageSize == null ? 15 : pageSize);

		List<Staff> staffs = service.findAll(ssb);

		// 获取PageInfo对象
		PageInfo<Staff> pi = new PageInfo<>(staffs);
		map.put("staffs", staffs);
		map.put("pi", pi);
		return "staff/list";
	}

	@GetMapping("/one2many")
	public String one2many() {
		List<Depart> departs = ds.findAll();
		System.out.println(departs.size());
		System.out.println(departs.get(0).getName());
		return "staff/list";
	}

	/**
	 * @param ids
	 * @return //@ResponseBody的作用其实是将java对象转为json格式的数据。
	 */
	@PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {
		Map<String, Object> resp = new HashMap<>();
		int rows = service.deleteByIds(ids);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "删除数据时异常");
		}
		return resp;
	}

	@GetMapping("/add")
	public String add() {
		return "staff/add";
	}

	/*@PostMapping("/add")
	public ModelAndView submitAdd(Staff staff) {
		ModelAndView mav = new ModelAndView();
		if (staff.getStaffId() == null || staff.getStaffId().trim().length() == 0) {
			mav.addObject("error", "商品编号不允许为空");
			mav.setViewName("staff/add");
			mav.addObject("staff", staff);
			return mav;
		}
		Boolean success;
		try {
			success = service.save(staff);
		} catch (Exception e) {
			mav.addObject("error", "操作错误");
			mav.setViewName("staff/add");
			mav.addObject("staff", staff);
			return mav;
		}
		System.out.println(success);
		if (success) {
	
			mav.setViewName("redirect:/staff/list");
			return mav;
		} else {
	
			mav.addObject("error", "商品添加失败");
			mav.setViewName("staff/add");
			mav.addObject("staff", staff);
			return mav;
		}
	}*/
	@PostMapping("/add")
	public String add(Staff staff, Map<String, Object> map) {
		if (staff.getStaffId() == null || staff.getStaffId().trim().length() == 0) {
			map.put("error", "学号不允许为空");
			return "staff/add";
		}
		boolean success = service.save(staff);
		if (success) {
			return "redirect:/staff/list";

		} else {
			map.put("error", "保存数据失败");
			return "staff/add";
		}

	}

	/**
	 * 跳转到修改页面
	 */
	/*@GetMapping("/edit")
	public ModelAndView gotoEdit(String id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView();
		if (id == null || id.trim().length() == 0) {
			mav.addObject("error", "未选择要修改的信息");
			mav.setViewName("employee/list");
			return mav;
		} else {
			Staff staff = service.findById(Integer.valueOf(id));
			if (staff == null) {
				mav.addObject("error", "要修改的员工信息不存在");
				mav.setViewName("staff/list");
				return mav;
			} else {
				mav.addObject("staff", staff);
				mav.setViewName("staff/edit");
				return mav;
			}
		}
	}*/
	@GetMapping("/edit")
	public String gotoEdit(Integer id, Map<String, Object> pramg) {
		if (id == null) {
			pramg.put("error", "未选中信息");
			return "staff/edit";
		}
		Staff staff = service.findById(Integer.valueOf(id));
		if (staff == null) {
			pramg.put("error", "要修改的员工信息不存在");
			return "staff/edit";
		} else {
			pramg.put("staff", staff);
			return "staff/edit";
		}

	}

	/**
	 * 提交修改表单
	 */
	@PostMapping("/edit")
	public ModelAndView submitEdit(HttpServletRequest req, Staff staff,
			@RequestParam(name = "picture-pic") MultipartFile file) {

		// System.out.println(file.getName());
		// System.out.println(file.getSize());

		ModelAndView mav = new ModelAndView();
		if (staff.getStaffId() == null || staff.getStaffId().trim().length() == 0) {
			mav.addObject("error", "员工编号不允许为空");
			mav.addObject("staff", staff);
			mav.setViewName("staff/edit");
			return mav;
		}
		// 根据电脑随机生成一个数,保证不重复，36位随机数
		String uid = UUID.randomUUID().toString();
		// 原始文件名
		String originalName = file.getOriginalFilename();
		// 源文件扩展名
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 文件扩展名
		// 用户可自定义位置
		// String fullName = Global.UPLOAD_PICTURE + "/" + uid + "." + ext;// 文件全名

		// 使用相对路径
		String pictu = req.getServletContext().getRealPath("/upload/image/prcture");
		String fullName = pictu + "/" + uid + "." + ext;

		File target = new File(fullName);
		try {
			// 流操作不可避免要进行捕获异常
			file.transferTo(target);
			staff.setPicture("/upload/image/prcture" + uid + "." + ext);
			System.out.println(fullName);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Boolean success;
		try {
			success = service.update(staff);
		} catch (Exception e) {
			mav.addObject("error", "操作异常");
			mav.addObject("staff", staff);
			mav.setViewName("staff/edit");
			return mav;
		}
		// 如果成功
		if (success) {
			mav.setViewName("redirect:/staff/list");
			return mav;
		} else {
			mav.addObject("error", "员工修改信息失败");
			mav.addObject("staff", staff);
			mav.setViewName("staff/edit");
			return mav;
		}
	}

}
