package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dto.ContactMethodsDTO;
import com.example.demo.entity.ContactMethodsEntity;
import com.example.demo.request.ContactMethodsRequest;

@Mapper(componentModel = "spring")
public interface ContactMethodsMapper {

	ContactMethodsDTO toDto(ContactMethodsEntity contactMethodsEntity);

	List<ContactMethodsDTO> todDtoList(List<ContactMethodsEntity> contactMethodsEntity);

	ContactMethodsEntity toEntity(ContactMethodsRequest contactMethodsRequest);

}
