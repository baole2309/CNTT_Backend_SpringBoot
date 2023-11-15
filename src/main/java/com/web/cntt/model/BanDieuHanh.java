package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banDieuHanh")
public class BanDieuHanh extends BaseEntity {
    @Id
    private UUID maBanDieuHanh;
    private String firstName;
    private String lastName;
    private String chucVu;
    private String description;
    private String email;
    private String phoneNumber;
    private String image;
}
