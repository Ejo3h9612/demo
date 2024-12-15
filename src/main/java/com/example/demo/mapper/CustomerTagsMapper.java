package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.CustomerTagsDTO;
import com.example.demo.entity.CustomerTagsEntity;
import com.example.demo.request.CustomerTagsRequest;

@Mapper(componentModel = "spring")
public interface CustomerTagsMapper {

	CustomerTagsDTO toDto(CustomerTagsEntity contactMethodsEntity);

	List<CustomerTagsDTO> todDtoList(List<CustomerTagsEntity> contactMethodsEntity);

	CustomerTagsEntity toEntity(CustomerTagsRequest customerTagsRequest);

}
