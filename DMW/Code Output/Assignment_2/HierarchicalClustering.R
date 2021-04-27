#Hierarchical clustering

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

#Scaling the dataset
  Iris.scaled <-scale(Iris.features) #mean 0 sd 1 
  head(Iris.scaled)
#Computing distance between observations return distance matrix
  res.dist <- dist(x=Iris.scaled, method = "euclidean" )
  
  x<- as.matrix(res.dist)[1:5,1:5]
  x
  
  round(x,digits = 3);

#Implementing Hierarchical clustering
  #Linkage methods
    #Complete-linkage : computes max distance before merging
    #Single-linkage : computes min distance between clusters before merging
    #Average-linkage : computes avg distance before merging.
    #Centroid-linkage : computes distance between centroids before merging

  res.hc <- hclust(d=res.dist, method = "complete");

# Cut tree into 3 groups and plot ClusterPlot
  sub_grp <- cutree(res.hc, k = 3);
  fviz_cluster(list(data = Iris.features, cluster = sub_grp));
  
#plot Dendogram with k = 3 clusters
  plot(res.hc, cex = 0.6)
  rect.hclust(res.hc, k = 3, border = 2:5)
  
  
  