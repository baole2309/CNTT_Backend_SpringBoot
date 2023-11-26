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
@Table(name = "gtCuuSV")
public class GTCuuSV extends BaseEntity {
    @Id
    private UUID maGtCuuSV;
    private String title;
    private String description;
    private String aim;
    private String image;
    private Date ngayTB;

}
