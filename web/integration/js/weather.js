

const weatherConditions = {
    "晴": "☀️",
    "少云": "🌤",
    "晴间多云": "⛅️",
    "多云": "☁️",
    "阴": "🌥",
    "有风": "🌬️",
    "平静": "🌀", 
    "微风": "🌬️",
    "和风": "🌬️",
    "清风": "🌬️",
    "强风/劲风": "💨",
    "疾风": "💨",
    "大风": "🌪",
    "烈风": "🌪",
    "风暴": "🌪",
    "狂爆风": "🌪",
    "飓风": "🌀",
    "热带风暴": "🌀",
    "霾": "🌫️",
    "中度霾": "🌫️",
    "重度霾": "🌫️",
    "严重霾": "🌫️",
    "阵雨": "🌦",
    "雷阵雨": "⛈",
    "雷阵雨并伴有冰雹": "⛈",
    "小雨": "🌧",
    "中雨": "🌧",
    "大雨": "🌧",
    "暴雨": "🌧",
    "大暴雨": "🌧",
    "特大暴雨": "🌧",
    "强阵雨": "🌧",
    "强雷阵雨": "⛈",
    "极端降雨": "🌧",
    "毛毛雨/细雨": "🌦",
    "雨": "🌧",
    "小雨-中雨": "🌦",
    "中雨-大雨": "🌧",
    "大雨-暴雨": "🌧",
    "暴雨-大暴雨": "🌧",
    "大暴雨-特大暴雨": "🌧",
    "雨雪天气": "🌨",
    "雨夹雪": "🌨",
    "阵雨夹雪": "🌨",
    "冻雨": "🌨",
    "雪": "❄️",
    "阵雪": "❄️",
    "小雪": "❄️",
    "中雪": "❄️",
    "大雪": "❄️",
    "暴雪": "❄️",
    "小雪-中雪": "❄️",
    "中雪-大雪": "❄️",
    "大雪-暴雪": "❄️",
    "浮尘": "🌫",
    "扬沙": "🌫",
    "沙尘暴": "🌪",
    "强沙尘暴": "🌪",
    "龙卷风": "🌪",
    "雾": "🌫",
    "浓雾": "🌫",
    "强浓雾": "🌫",
    "轻雾": "🌫",
    "大雾": "🌫",
    "特强浓雾": "🌫",
    "热": "🔥",
    "冷": "❄️",
    "未知": "❓"
};
document.addEventListener('DOMContentLoaded', function() {
    var cityCode = "110101"; 
    var Key= "8a4405b9049f24a25d8a82826f7ab936"

    fetchWeatherInfo(cityCode, Key);
});

function fetchWeatherInfo(city, key) {
    var url = `https://restapi.amap.com/v3/weather/weatherInfo?city=${city}&key=${key}&extensions=base&output=json`;


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