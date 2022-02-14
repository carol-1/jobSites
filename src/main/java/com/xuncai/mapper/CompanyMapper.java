package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

	public int create(Company company);

	public int delete(Integer id);

	public int update(Company company);

	public int updateSelective(Company company);

	public List<Company> query(Company company);

	public Company detail(Integer id);

	public int count(Company company);

}