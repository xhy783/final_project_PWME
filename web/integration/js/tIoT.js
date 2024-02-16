
document.addEventListener('DOMContentLoaded', function() {
    var cityCode = "110101"; 
    var Key= "8a4405b9049f24a25d8a82826f7ab936"

    fetchWeatherInfo(cityCode, Key);
});

function fetchTempInfo(city, key) {
    var url = `占个位置`;


    fetch(url)
    .then(response => response.json())
    .then(data => {
        if (data && data.status === "1" && data.lives && data.lives.length > 0) {
            var weatherData = data.lives[0];
            updateWeatherInfo(weatherData);
            updateWeatherSymbol(weatherData.weather); 
        } else {
            throw new Error('天气信息获取失败');
        }
    })
    .catch(error => {
        console.error('获取天气信息出错:', error);
        document.getElementById('weather-data').textContent = '无法加载天气信息';
    });
}

function updateWeatherInfo(weatherData) {
    var weatherInfo = `Current temperature outdoors: ${weatherData.temperature}°C, Weather: ${weatherData.weather}`;
    document.getElementById('weather-data').textContent = weatherInfo;
}

function updateWeatherSymbol(condition) {
    const symbol = weatherConditions[condition] || ""; 
    document.getElementById('weather-data').textContent += ` ${symbol}`;
}