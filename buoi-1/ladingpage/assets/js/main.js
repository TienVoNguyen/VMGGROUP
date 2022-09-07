const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
const navs = $$('.nav-link');
const nav = $('#navbar');
const brand = document.querySelector('.navbar-brand');
const features = $('#features');
const home = $('#home');
const about = $('#about');
const contact = $('#contact');
const testimonial = $('#testimonial');
document.addEventListener('scroll',function(){
    var x = scrollY;
    if(x === 0) {
        nav.classList.remove('bg-light');
        navs.forEach(nav => {
            nav.classList.add('text-white');
        });
        brand.classList.add('text-white');
    } else if(x > 5 && x < 1500) {
        nav.classList.add('bg-light');
        navs.forEach(nav => {
            nav.classList.remove('text-white','active','text-primary');
        });
        home.classList.add('active','text-primary');
        brand.classList.remove('text-white');
        brand.classList.add('text-black');
    } else if(x >= 1500 && x< 3700) {
        navs.forEach(nav => {
            nav.classList.remove('text-white', 'active', 'text-primary');
        });
        features.classList.add('active','text-primary')
    } else if(x >= 3700 && x < 4500) {
        navs.forEach(nav => {
            nav.classList.remove('text-white', 'active', 'text-primary');
        });
        about.classList.add('active','text-primary')
    } else if(x >= 4500 && x< 5000) {
        navs.forEach(nav => {
            nav.classList.remove('text-white', 'active', 'text-primary');
        });
        testimonial.classList.add('active','text-primary')
    } else if(x >= 5000) {
        navs.forEach(nav => {
            nav.classList.remove('text-white', 'active', 'text-primary');
        });
        contact.classList.add('active','text-primary')
    }
});