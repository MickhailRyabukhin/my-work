public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperature = new float[patientsCount];
        double patientTemp;
        //TODO: напишите метод генерации массива температур пациентов

        for (int i = 0; i < patientsCount; i++) {
            patientTemp = 32f + (Math.random() * 8.0);
            patientTemp = Math.round(patientTemp * 10.0);
            temperature[i] = (float) patientTemp / 10.0f;
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float averageTemp, sum = 0;
        StringBuilder patientTemp = new StringBuilder();
        int helthCount = 0;
        for (float temperatureDatum : temperatureData) {                     // перебор всех членов массива
            if (temperatureDatum >= 36.2f && temperatureDatum <= 36.9f) {    // (float temperatureDatum =
                helthCount++;                                                // temperatureData [i])
            }
            sum += temperatureDatum;
            patientTemp.append(" ").append(temperatureDatum);
        }
        averageTemp = (temperatureData.length > 0) ? sum / temperatureData.length : 0;
        averageTemp = Math.round(averageTemp * 100);
        averageTemp = averageTemp / 100;

        return "Температуры пациентов:" + patientTemp +
                "\nСредняя температура: " + averageTemp +
                "\nКоличество здоровых: " + helthCount;
    }
}
