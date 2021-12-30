<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url]
[![Stargazers][stars-shield]][stars-url]
[![MIT License][license-shield]][license-url]

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://www.google.com/search?q=GET%C4%B0R&rlz=1C1GCEU_enTR848TR848&sxsrf=AOaemvK1GjQ2DLUSbzQpK6sYvwaxfV1jFg:1640902494741&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjS8LySxoz1AhWwQ_EDHR2MDeMQ_AUoA3oECBsQBQ&biw=2560&bih=1329&dpr=1#imgrc=zaKWed15DciKaM)


<p align="right">(<a href="#top">back to top</a>)</p>

ReadingIsGood is an online books retail firm which operates only on the Internet. Main
target of ReadingIsGood is to deliver books from its one centralized warehouse to their
customers within the same day.

### Used Techs

- JDK 11
- MongoDB
- Spring Stack (Boot, Security)
- Multi-modular maven project

Use the `README.md` to get started.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps. This is an example of how to list things you need to use the software and how to install them.

* Built with Maven


  ```sh
  mvn clean install
  ```
  
* Open API Url


  ```sh
  http://localhost:5000/swagger-ui/index.html
  ```
  
* Public end-points


  ```sh
  "/v2/api-docs",
  "/swagger-resources",
  "/swagger-resources/**",
  "/configuration/ui",
  "/configuration/security",
  "/swagger-ui.html",
  "/webjars/**",
  
  // -- Swagger UI v3 (OpenAPI)
  "/v3/api-docs/**",
  "/swagger-ui/**",
  
  // other public endpoints
  "/home/**"
  ```            

## Usage and Roadmap

* The project mostly do these things.

  - [x] Registering New Customer
  - [x] Placing a new order
  - [x] Query Monthly Statistics
  - [x] Tracking the stock of books
  - [x] List all orders of the customer
  - [x] Viewing the order details

* All entities intercepted before DDL operations with ProductBeforeSaveInterceptor. Logged with username who changes the entity when inserts and updates in transaction.
* Project generic response will be like this. The logged in endpoint is **/home/login**. Will be retrieve jwt token in response header. You need to add Authorization header into your request headers to access private endpoints.
  ```sh
  Request:
    {
      "email":"username",
      "password":"password"
    }
    
  Response:
    {
      "code": 0,
      "data": {
          "resultCode": "OK"
      }
    }
  ```
* All request/response samples in classpath://request.postman_collection.json

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Emrullah YILDIRIM - [@emrullahyildirim](https://www.linkedin.com/in/emrullahyildirim/) - emrullahyildirim@windowslive.com

Project Link: [https://github.com/Sangaibisi/getir-bi-mutluluk](https://github.com/Sangaibisi/getir-bi-mutluluke)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/badge/Contributors-1-w
[contributors-url]: https://github.com/Sangaibisi/getir-bi-mutluluk/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/badge/Stars-1-w
[stars-url]: https://github.com/Sangaibisi/getir-bi-mutluluk/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/badge/License-MIT-w
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/emrullahyildirim/
[product-screenshot]: RootBackend/src/main/webapp/WEB-INF/images/getir.jpg
