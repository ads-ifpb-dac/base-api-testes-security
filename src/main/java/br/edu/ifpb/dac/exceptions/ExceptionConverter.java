package br.edu.ifpb.dac.exceptions;

import br.edu.ifpb.dac.pessoa.PessoaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionConverter {

    // Aqui, inclua a exceção que deseja tratar
    @ExceptionHandler(PessoaNaoEncontradaException.class)
    // E em qual código HTTP ela deve ser traduzida
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDTO converter(PessoaNaoEncontradaException e) {
        /* No corpo do método, faça a lógica necessária para buscar os dados da exceção e mostrar em algum
        formato a sua escolha. Aqui, utilizei ExceptionDTO, mas pode ser qualquer formato que você desejar.
         */
        String message = e.getMessage();
        return new ExceptionDTO(message);
    }

}
