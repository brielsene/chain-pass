package br.com.chainpass.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDetails {
    private String recipient;
    private String messageBody;
    private String subject;
    private String attachment;
}
