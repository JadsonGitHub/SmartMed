package br.com.smartmed.consultas.model;

import br.com.smartmed.consultas.rest.dto.ConsultaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class ConsultaModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dataHoraConsulta", nullable = false)
    private LocalDate dataHoraConsulta;

    @Column(name = "status", length = 16, nullable = false)
    @Length(min = 8, max = 16, message = "Agendada;\n Cancelada;\n Realizada;\n Retorno.")
    private String status;

    @Column(name = "valor", nullable = false)
    private float valor;

    @Column(name = "observacoes", length = 1024, nullable = true)
    private String observacoes;

    @Column(name = "pacienteID", nullable = false)
    private int pacienteID;

    @Column(name = "medicoID", nullable = false)
    private int medicoID;

    @Column(name = "formaPagamentoID", nullable = true)
    private int formaPagamentoID;

    @Column(name = "convenioID", nullable = true)
    private int convenioID;

    @Column(name = "recepcionistaID", nullable = false)
    private int recepcionistaID;

    public ConsultaDTO toDTO()
    {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ConsultaDTO.class);
    }
}