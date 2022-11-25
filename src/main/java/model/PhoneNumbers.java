package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
@Table(name = "phone_numbers")
public class PhoneNumbers {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JoinColumn(name = "project_id")
    private int projectId;
}
