package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Certificate;

public interface CertificateMapper {

	public int create(Certificate certificate);

	public int delete(Integer id);

	public int update(Certificate certificate);

	public int updateSelective(Certificate certificate);

	public List<Certificate> query(Certificate certificate);

	public Certificate detail(Integer id);

	public int count(Certificate certificate);

}