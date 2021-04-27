
#K-means clustering
  #Packages
  require(stats)
  require(factoextra)
  require(ggplot2)
 
  #read data from file to dataframe
    Iris<-read.table("iris.data",header=TRUE,sep=","); 
    View(Iris);
  # Create another dataframe for operations
    Iris.features <- Iris;
    Iris.features$species <- NULL;
    View(Iris.features);
   
  #wss plot to choose max num of cluster 
    wssplot <- function(data, nc=15, seed=1234){
      wss <- (nrow(data)-1)*sum(apply(data,2,var))
      for(i in 2:nc){
        set.seed(seed)
        wss[i] <- sum(kmeans(data, centers=i)$withinss)
      }
      plot(1:nc, wss, type="b", xlab = "Number Of clusters", 
           ylab = "Within groups sum of squares")
    }
    
  wssplot(Iris.features)
    
  #Implementing k-means clustering algorithm
    results <- kmeans(Iris.features, 2);
    results
  #component wise results
    results$size
    results$centers
  #how the data divided into clusters
    table(Iris$species, results$cluster);
    
  #Plotting the graph
    plot(Iris[c("sepal_length","sepal_width")], col = results$cluster);
    #comparing plot with original dataset
      plot(Iris[c("sepal_length","sepal_width")], col = iris$Species);
    
    plot(Iris[c("petal_length","petal_width")], col = results$cluster);
    #comparing plot with original dataset
       plot(Iris[c("petal_length","petal_width")], col = iris$Species);

  #Graph 
  fviz_cluster(list(data = Iris.features, cluster = results$cluster));















    