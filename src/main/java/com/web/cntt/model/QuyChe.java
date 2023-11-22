package com.web.cntt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quyChe")
public class QuyChe {
    @Id
    private UUID maQuyChe;
    private String tenQuyChe;
    private String content;
    private Date ngayApDung;
}
