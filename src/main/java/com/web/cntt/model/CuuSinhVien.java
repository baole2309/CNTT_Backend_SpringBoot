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
@Table(name = "cuuSinhVien")
public class CuuSinhVien extends BaseEntity {
    @Id
    private String maCuuSV;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String phoneNumber;
}
