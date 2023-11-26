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
@Table(name = "anhNen")
public class AnhNen extends BaseEntity{
    @Id
    private UUID maAnhNen;
    private String name;
    private String resource;
    private String description;

}
