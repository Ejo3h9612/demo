package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.CustomerInfoDTO;
import com.example.demo.entity.CustomerInfoEntity;

@Mapper(componentModel = "spring")
public interface CustomerInfoMapper {

	CustomerInfoDTO toDto(CustomerInfoEntity contactMethodsEntity);

	List<CustomerInfoDTO> todDtoList(List<CustomerInfoEntity> contactMethodsEntity);
}
