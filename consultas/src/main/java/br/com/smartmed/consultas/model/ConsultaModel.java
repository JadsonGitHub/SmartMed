package br.com.smartmed.consultas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class ConsultaModel {
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

//    @Column(name = "pacienteID", nullable = false)
//    private int pacienteID;
//
//    @Column(name = "medicoID", nullable = false)
//    private int medicoID;
//
//    @Column(name = "formaPagamentoID", nullable = true)
//    private int formaPagamentoID;
//
//    @Column(name = "convenioID", nullable = true)
//    private Integer convenioID;
//
//    @Column(name = "recepcionistaID", nullable = false)
//    private int recepcionistaID;

    @ManyToOne
    @JoinColumn(name = "pacienteID", insertable = false, updatable = false)
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "medicoID", insertable = false, updatable = false)
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "recepcionistaID", insertable = false, updatable = false)
    private RecepcionistaModel recepcionista;

    @ManyToOne
    @JoinColumn(name = "convenioID", insertable = false, updatable = false)
    private ConvenioModel convenio;

    @ManyToOne
    @JoinColumn(name = "formaPagamentoID", insertable = false, updatable = false)
    private FormaPagamentoModel formaPagamento;

//    memory leak
//    public ConsultaDTO toDTO() {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(this, ConsultaDTO.class);
//    }
}
