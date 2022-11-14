package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table
@Data
public class Dkv {

    @NotEmpty
    @Column(name = "dkv_umber")
    private int Number;
    @NotEmpty
    @Column(name = "serial_number")
    private Long serial;
}
