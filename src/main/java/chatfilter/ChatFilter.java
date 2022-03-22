package chatfilter;

import com.example.chat.demo.chat.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class ChatFilter
{
    private static  final Logger log= LoggerFactory.getLogger(ChatFilter.class);


    public void  palabrasBuenasList()
    {
        List<Chat> palabrasBuenas= new ArrayList<>();
        palabrasBuenas.add(new Chat("Buenos días"));
        palabrasBuenas.add(new Chat("Cordial saludo"));
        palabrasBuenas.add(new Chat("Buenas tardes"));
        palabrasBuenas.add(new Chat("Buenas noches"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));

        Flux<Chat> fx1= Flux.fromIterable(palabrasBuenas);

    }


    public void palabrasMalasList()
    {
        List<Chat> palabrasMalas= new ArrayList<>();
        palabrasMalas.add(new Chat("Asqueroso"));
        palabrasMalas.add(new Chat("Cerdiar"));
        palabrasMalas.add(new Chat("Barbitonto"));
        palabrasMalas.add(new Chat("Papanatas"));
        palabrasMalas.add(new Chat("Golfa"));
        palabrasMalas.add(new Chat("Trifásico"));
        palabrasMalas.add(new Chat("Pirobo"));
        palabrasMalas.add(new Chat("Zopenco"));
        palabrasMalas.add(new Chat("Gonorrea"));
        palabrasMalas.add(new Chat("Perra"));


        Flux.fromIterable(palabrasMalas)
                .map(palabra->
        {
                //palabra.setPalabras(String.valueOf(palabra.getPalabras().replaceAll("[\\[Asqueroso\\]|#]", "*").split("[,|\n]")));
            //palabra.setPalabras(palabra.getPalabras().replaceAll([],"***"));
                return  palabra;
        }).subscribe(p->log.info("palabras:" + p));
    }

    public void listasUnidas()
    {
        List<Chat> palabrasBuenas= new ArrayList<>();
        palabrasBuenas.add(new Chat("Buenos días"));
        palabrasBuenas.add(new Chat("Cordial saludo"));
        palabrasBuenas.add(new Chat("Buenas tardes"));
        palabrasBuenas.add(new Chat("Buenas noches"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));
        palabrasBuenas.add(new Chat("Abrazo fuerte"));


        List<Chat> palabrasMalas= new ArrayList<>();
        palabrasMalas.add(new Chat("Asqueroso"));
        palabrasMalas.add(new Chat("Cerdiar"));
        palabrasMalas.add(new Chat("Barbitonto"));
        palabrasMalas.add(new Chat("Papanatas"));
        palabrasMalas.add(new Chat("Golfa"));
        palabrasMalas.add(new Chat("Trifásico"));
        palabrasMalas.add(new Chat("Pirobo"));
        palabrasMalas.add(new Chat("Zopenco"));
        palabrasMalas.add(new Chat("Gonorrea"));
        palabrasMalas.add(new Chat("Perra"));

        Flux<Chat> fx1= Flux.fromIterable(palabrasBuenas);
        Flux<Chat> fx2= Flux.fromIterable(palabrasMalas);


        Flux.merge(fx1,fx2).map(palabra->palabra.getPalabras().replaceAll("Asqueroso","***"))
                .subscribe(p->log.info("palabras:" + p));



    }



}
