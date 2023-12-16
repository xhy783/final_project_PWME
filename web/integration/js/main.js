
    // Menu Responsive
    document.addEventListener('DOMContentLoaded', function () {
        const menuToggle = document.querySelector('.menu-toggle');
        const menuClose = document.querySelector('.menu-close');
        const menuResponsive = document.querySelector('.menu-responsive');
    
        menuToggle.addEventListener('click', function () {
            menuResponsive.style.display = 'flex';
            menuToggle.style.display = 'none';
            menuClose.style.display = 'block';
        });
    
        menuClose.addEventListener('click', function () {
            menuResponsive.style.display = 'none';
            menuToggle.style.display = 'block';
            menuClose.style.display = 'none';
        });
    });
    


