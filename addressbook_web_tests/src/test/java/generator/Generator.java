package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import common.CommonFunctions;
import model.GroupData;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {
    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-n"})
    int count;



    public static void main(String[] args) throws IOException {//args-это аргументы для запуска функции(Прописываем в Edit configurations  --type groups --output groups.json --format json --count 3
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
        //new Generator().run();//создать новый генератор и запустить
    }

    private void run() throws IOException {// метод run вызывает две вспомогательные функции(первая генерирует данные, а вторая сохраняет)
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)){
            return generateGroups();
        }else  if("contacts".equals(type)){
            return generateContacts();
        }else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();//создаем список объектов типа GroupData
        for (int i = 0; i < count; i++) {//цикл для повторяния действия,которое в фигурных скобках
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));//добавляем объекты типа GroupDate со случано сгенерированным name,header,footer
        }
        return result;
    }

    private Object generateContacts() {
        return null;
    }


    private void save(Object data) throws IOException {
        if ("json".equals(format)){
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(output), data);
        }
        else {
            throw new IllegalArgumentException("Неизвестный формат данных" + format);
        }
    }


}
