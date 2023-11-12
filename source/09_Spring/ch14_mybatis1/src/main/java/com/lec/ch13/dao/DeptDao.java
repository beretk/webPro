package com.lec.ch13.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lec.ch13.dto.Dept;
public interface DeptDao {
	public List<Dept> deptList();
}
