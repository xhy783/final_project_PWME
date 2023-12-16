document.addEventListener('DOMContentLoaded', function() {
    var currentTemperature = 20;
    var slider = document.getElementById('temperature-slider');
    var presetTemperature = parseInt(slider.value);
    document.getElementById('preset-temperature').textContent = presetTemperature;

    // 每0.01秒更新阴影
    setInterval(() => {
        var newPresetTemperature = parseInt(slider.value);
        if (newPresetTemperature !== presetTemperature) {
            presetTemperature = newPresetTemperature;
            document.getElementById('preset-temperature').textContent = presetTemperature;
        }
        var shadow = calculateShadow(presetTemperature);
        var temperatureContainer = document.getElementById('temperature-container');
        temperatureContainer.style.boxShadow = shadow;
    }, 10);

    // 每1秒更新当前温度
    setInterval(() => {
        if (currentTemperature < presetTemperature) {
            currentTemperature++;
        } else if (currentTemperature > presetTemperature) {
            currentTemperature--;
        }

        updateTemperature(currentTemperature, presetTemperature);
    }, 1000);
});



function updateTemperature(temperature, presetTemperature) {
    var temperatureElement = document.getElementById('temperature-value');
    temperatureElement.textContent = temperature + '°C';
    temperatureElement.style.color = getColorForTemperature(temperature);
}

function getColorForTemperature(temperature) {
    var hue = 240 - (temperature - 10) * 11;
    return `hsl(${hue}, 100%, 50%)`;
}

function calculateShadow(presetTemperature) {
    
    var shadowX = (presetTemperature - 20) * -2;

    var shadowOpacity = 0 + (presetTemperature - 20) * 0.009;
    return `${shadowX}px -20px 20px rgba(173, 173, 173, ${shadowOpacity})`;
}
