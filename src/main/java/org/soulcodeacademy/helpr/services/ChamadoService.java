package org.soulcodeacademy.helpr.services;

import net.bytebuddy.asm.Advice;
import org.soulcodeacademy.helpr.domen.Chamado;
import org.soulcodeacademy.helpr.domen.Cliente;
import org.soulcodeacademy.helpr.domen.Funcionario;
import org.soulcodeacademy.helpr.domen.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domen.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ClienteService clienteService; // para saber se e valido no relacionanamento
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> listarChamados() {
        return this.chamadoRepository.findAll();
    }

    public Chamado getChamado(Integer idChamado) {
        return this.chamadoRepository.findById(idChamado).orElseThrow(() -> new RuntimeException("Chamado nao encontrado"));


    }


    public Chamado salvar(ChamadoDTO dto) {
        //verificar se existe um cliente com este ID
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());
        Chamado chamado = new Chamado(null, dto.getTitulo(), dto.getDescricao());
        chamado.setCliente(cliente);

        return this.chamadoRepository.save(chamado);

    }

    public Chamado atualizar(Integer idChamado, ChamadoDTO dto) {
        //Verifica se existe ou não
        Chamado chamadoAtual = this.getChamado(idChamado);
        Cliente clienteAtual = this.clienteService.getCliente(dto.getIdCliente());
        chamadoAtual.setTitulo(dto.getTitulo());
        chamadoAtual.setDescricao(dto.getDescricao());
        chamadoAtual.setCliente(clienteAtual);

        if (dto.getIdFuncionario() == null) {
            throw new RuntimeException("idFuncionario obrigatorio");
        } else {
            Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
            switch (dto.getStatus()) {
                case RECEBIDO -> {
                    chamadoAtual.setStatus(StatusChamado.RECEBIDO);
                    chamadoAtual.setFuncionario(null);
                    chamadoAtual.setDataFechamento(null);
                }
                case ATRIBUIDO -> {
                    chamadoAtual.setStatus(StatusChamado.ATRIBUIDO);
                    chamadoAtual.setFuncionario(funcionario);
                    chamadoAtual.setDataFechamento(null);
                }
                case CONCLUIDO -> {
                    chamadoAtual.setStatus(StatusChamado.CONCLUIDO);
                    chamadoAtual.setFuncionario(funcionario);
                    chamadoAtual.getDataFechamento(LocalDate.now());
                }
            }
        }
        return this.chamadoRepository.save(chamadoAtual);

    }

    public List<Chamado> listarPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = this.funcionarioService.getFuncionario(idFuncionario);
        return this.chamadoRepository.findByFuncionario(funcionario);
    }
    public List<Chamado> listarPorCliente (Integer idCliente) {
        Cliente cliente = this.clienteService.getCliente(idCliente);
        return this.chamadoRepository.findByCliente(cliente);
    }

    public  List<Chamado>listarPorIntervaloDatas(LocalDate data1, LocalDate data2){
        return this.chamadoRepository.buscarEntreDatas(data1, data2);
    }

    public List<Chamado> listarPorStatus(StatusChamado status) {
        return this.chamadoRepository.findByStatus(status);
    }



}

