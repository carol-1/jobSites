package com.xuncai.mapper;

import java.util.List;
import java.util.Map;

import com.xuncai.entity.Channel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChannelMapper {

	public int create(Channel channel);

	public int delete(Integer id);

	public int update(Channel channel);

	public int updateSelective(Channel channel);

	public List<Channel> query(Channel channel);

	public Channel detail(Integer id);

	public int count(Channel channel);

}