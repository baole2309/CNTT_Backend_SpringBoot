package com.web.cntt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
@Getter
@Setter
public class BaseEntity {

    @Column
    private String createBy;
    @Column
    private Date createDate;
    @Column
    private String modifiedBy;
    @Column
    private Date modifiedDate;
}
