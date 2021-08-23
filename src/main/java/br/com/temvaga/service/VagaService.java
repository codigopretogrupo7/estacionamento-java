package br.com.temvaga.service;

import br.com.temvaga.model.Estacionamento;
import br.com.temvaga.model.Vaga;
import br.com.temvaga.model.Veiculo;
import br.com.temvaga.repository.EstacionamentoRepository;
import br.com.temvaga.repository.VagaRepository;
import br.com.temvaga.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class VagaService {

    Calendar calendario = Calendar.getInstance();
    Locale local = new Locale("PT","BR");
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat dia = new SimpleDateFormat("d");
    SimpleDateFormat mes = new SimpleDateFormat("M");

    Random random = new Random();

    @Autowired
    EstacionamentoRepository estacionamentoRepository;
    @Autowired
    VagaRepository vagaRepository;
    @Autowired
    VeiculoRepository veiculoRepository;

    public ResponseEntity<Vaga> vagaPorId(Integer id){
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if(vaga.isPresent()){
            return new ResponseEntity<Vaga>(vaga.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ArrayList<Vaga>> todasAsVagas(){
        ArrayList<Vaga> vagas = (ArrayList<Vaga>) vagaRepository.findAll();
        if( vagas.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<ArrayList<Vaga>>(vagas, HttpStatus.OK);
        }
    }

    public ResponseEntity<ArrayList<Vaga>> listaVagas(Integer numeroEstacionamento ) {
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(numeroEstacionamento);

        if( estacionamento.isPresent() ){
            ArrayList<Vaga> vagas = vagaRepository.findAllByEstacionamento(estacionamento.get());
            return new ResponseEntity<ArrayList<Vaga>>(vagas,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Integer> vagaslivres(Integer numeroEstacionamento){
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(numeroEstacionamento);

        if( estacionamento.isPresent() ){
            ArrayList<Vaga> vagas = vagaRepository.findAllByEstacionamento(estacionamento.get());
            ArrayList<Vaga> vagasVazias = new ArrayList<>();

            String situacao = "vazia";

            for( int i = 0 ; i < vagas.toArray().length ; i++ ){
                if(vagas.get(i).getSituacao().equals(situacao)){
                    vagasVazias.add(vagas.get(i));
                }
            }

            return new ResponseEntity<Integer>(vagasVazias.toArray().length,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vaga> ReservarVaga(Integer idEstacionamento, Veiculo carro){
        Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(idEstacionamento);
        if( estacionamento.isPresent() ){
            ArrayList<Vaga> vagas = vagaRepository.findAllByEstacionamento(estacionamento.get());
            ArrayList<Vaga> vagasVazias = new ArrayList<>();

            String situacao = "vazia";

            for( int i = 0 ; i < vagas.toArray().length ; i++ ){
                if(vagas.get(i).getSituacao().equals(situacao)){
                    vagasVazias.add(vagas.get(i));
                }
            }
            if(vagasVazias.toArray().length > 0){
                int numeroSorteado = random.nextInt(vagasVazias.toArray().length);
                Optional<Veiculo> veiculo = veiculoRepository.findById(carro.getId());

                Vaga vagaSorteada = vagasVazias.get(numeroSorteado);
                vagaSorteada.setVeiculo(veiculo.get());
                vagaSorteada.setHora_entrada(hora.format(calendario.getTime()).toString());
                vagaSorteada.setDia_entrada(dia.format(calendario.getTime()).toString());
                vagaSorteada.setMes_entrada(mes.format(calendario.getTime()).toString());
                vagaSorteada.setSituacao("reservada");
                vagaRepository.save(vagaSorteada);
                return new ResponseEntity<Vaga>(vagaSorteada,HttpStatus.OK);

            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vaga> InsereCarroNaVaga(Integer id, Veiculo carro){
        Optional<Veiculo> veiculo = veiculoRepository.findById(carro.getId());
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if( veiculo.isPresent() ){
            Vaga vagaCriada = vaga.get();
            vagaCriada.setVeiculo(veiculo.get());
            vagaCriada.setHora_entrada(hora.format(calendario.getTime()).toString());
            vagaCriada.setDia_entrada(dia.format(calendario.getTime()).toString());
            vagaCriada.setMes_entrada(mes.format(calendario.getTime()).toString());
            vagaCriada.setSituacao("ocupada");

            vagaRepository.save(vagaCriada);
            return new ResponseEntity<Vaga>(vagaCriada,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vaga> Checkout(Integer id){
        Optional<Vaga> vaga = vagaRepository.findById(id);

        if( vaga.isPresent() ){
            Vaga vagaCriada = vaga.get();
            vagaCriada.setVeiculo(null);
            vagaCriada.setHora_entrada(null);
            vagaCriada.setDia_entrada(null);
            vagaCriada.setMes_entrada(null);
            vagaCriada.setSituacao("vazia");

            vagaRepository.save(vagaCriada);
            return new ResponseEntity<Vaga>(vagaCriada,HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
