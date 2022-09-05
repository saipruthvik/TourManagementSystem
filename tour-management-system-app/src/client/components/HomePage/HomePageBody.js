import React from "react";

const HomePageBody = () => {
 
  return (
    <div>
        <div className="text-center p-3">
            <h1>My Home Tourism</h1>
        </div>
      <div
        id="carouselExampleIndicators"
        className="carousel slide"
        data-ride="carousel"
      >
        <ol className="carousel-indicators">
          <li
            data-target="#carouselExampleIndicators"
            data-slide-to="0"
            className="active"
          ></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="6"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="7"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="8"></li>
        </ol>
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img className="d-block w-100 " style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/OberoiUdaivilas.jpg`} alt="OberoiUdaivilas" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>OBEROI UDAIVILAS</h2>
            <p>Jodhpur, Rajasthan</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/GoldenTemple.jpg`}alt="GoldenTemple" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>GOLDEN TEMPLE</h2>
            <p>Amritsar, Punjab</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/Jatayu.jpg`} alt="Jatayu" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>JATAYU EARTH"S CENTER</h2>
            <p>kollam, Kerala</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/GolkondaFort.jpg`} alt="GolkondaFort" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>GOLKONDA FORT</h2>
            <p>Hyderabad, Telangana</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/Beach.jpg`} alt="Third slide" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>TARKARLI BEACH</h2>
            <p>Tarkarli, Maharashtra</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/Murudeshwar.jpg`} alt="Murudeshwar" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>MURUDESHWAR TEMPLE</h2>
            <p>Uttar Kannada, Karnataka</p>
          </div>
            
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/TharDesert.jpg`} alt="TharDesert" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>THAR DESERT</h2>
            <p>Churu, Rajasthan</p>
          </div>
          </div>
          <div className="carousel-item">
            <img className="d-block w-100" style={{"height":"70vh"}} src={`${process.env.PUBLIC_URL}/images/Manali.jpg`} alt="Manali" />
            <div className="carousel-caption d-none d-md-block ">
            <h2>MANALI</h2>
            <p>Manali, Himachal Pradesh</p>
          </div>
          </div>
        </div>
        <a
          className="carousel-control-prev"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="sr-only">Previous</span>
        </a>
        <a
          className="carousel-control-next"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="sr-only">Next</span>
        </a>
      </div>
    </div>
  );
};
export default HomePageBody;
