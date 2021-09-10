<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple Markers</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 80%;
        
       
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 80%;
        margin: 40px;
        padding: 0;
      }
    </style>
  </head>
  <body>
  

   
  
    <div id="map">
    <script>

      function initMap() {
        var myLatLng = {lat: ${latt} , lng: ${lngg} };

        var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: myLatLng
        });

        var marker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          title: '${centernamee}'     
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD1AhYRaxSPwz7a2UkB5pZ8JpTWz7GkIbU&callback=initMap">
    </script>
    
    </div>
    
  </body>
</html>