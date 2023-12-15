document.addEventListener('DOMContentLoaded', function() {
    var currentTemperature = 20; // 初始温度
    var slider = document.getElementById('temperature-slider');
    var presetTemperature = slider.value; // 获取滑块的初始预设温度
    document.getElementById('preset-temperature').textContent = presetTemperature;

    slider.oninput = function() {
        presetTemperature = this.value;
        document.getElementById('preset-temperature').textContent = presetTemperature;
    };

    setInterval(() => {
        if (currentTemperature < presetTemperature) {
            currentTemperature++;
        } else if (currentTemperature > presetTemperature) {
            currentTemperature--;
        }

        updateTemperature(currentTemperature);
    }, 3000); // 每3秒更新一次温度
});

function updateTemperature(temperature) {
    var temperatureElement = document.getElementById('temperature-value');
    temperatureElement.textContent = temperature + '°C';

    if (temperature < 10) {
        temperatureElement.style.color = '#0096FF'; // 冷
    } else if (temperature >= 10 && temperature < 20) {
        temperatureElement.style.color = '#FFD700'; // 适中
    } else {
        temperatureElement.style.color = '#FF4500'; // 热
    }
}
