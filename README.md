# Apple's 100 Most Played Album
Displays the top 100 most played songs.

### Screens
- Album List : On Launch the user see a table of albums showing two album per row. Each album displays name, artist, artowrk.
- Album Detail : When the user clicks on an item from Album List, a detail screen is opened displaying a larger image with additional info genre, release date and copyright info.

### Libraries
- Compose for UI
- Ream for storing data locally
- Coil for image caching and lazy loading
- Accompanist for making app full screen
- Retrofit for network implemenation
- Hilt for DI

### Architecture
- MVVM architecture 
  - Views consists of Compose Screens
  - ViewModel are the bridge between the views and data layer
  - Model consists of local and remote data management taking help of Repository pattern with datasources
- Methods are properly documented for easy understanding of what they do if not cleared by it's name
- Since the app is very small, didn't over complicate it with different modules. However it can be easily done in future due to neatly organized packages

### Limitation from Design
- The svg file of the `back` arrow in Zeplin has wrong proportions so it doesn't align to center. This should be fixed by UI designer. So I have used `back` icon from Android Studio
- The collapsed toolbar has blur effect which Android doesn't provide natively. I believe the design is iOS based. However, I have used alpha.
  - Same goes with `back` button. Have used alpha instead of blur
- Couldn't use RecyclerView on Detail Screen due to requirements. This would imply that if the content is huge the content might overlap with each other in small devices. This is limitation of design.

### Additional Things done which didn't have Zeplin designs
- Added a loading view until the data is loaded for better UX.
- Added a simple retry screen with button to retry the network call.

### Notes
- App only uses Light theme due to rule `FOLLOW THE ZEPLIN DESIGNS EXACTLY`
- App can be rotated however and data will be retained, however the UI won't change as Zeplin didn't have landscape references.
- When new data is fetched from API, old data is being cleared assuming that app shouldn't show stale data
- Using two different sizes of artwork instead of using a single image since it was not high quality.
  - One thumbnail to show in list screen
  - One Big artwork to show in detail screen
  
  
### Videos
https://user-images.githubusercontent.com/61079/190135923-2692f310-b635-4b90-a0d9-adede5b867c8.mov



https://user-images.githubusercontent.com/61079/190135962-38025ce6-9b84-4ae6-b6fc-d53cb15fb49d.mov



https://user-images.githubusercontent.com/61079/190135982-f7ad8b15-4647-4f89-aab7-b9ce8381348e.mov



https://user-images.githubusercontent.com/61079/190136005-83fb8876-35a8-4836-8931-9b15cdfb0da5.mov

