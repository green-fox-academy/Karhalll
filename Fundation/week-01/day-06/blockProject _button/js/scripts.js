function myFunction() { 
  var titleText = document.getElementById("title-text").value;
  var contentText = document.getElementById("content-text").value;

  var title = document.createElement('h3');
  title.innerHTML = titleText;
  var content = document.createElement('p');
  content.innerHTML = contentText;
  
  var newPost = document.createElement('div');
  newPost.setAttribute("class", "post");
  newPost.innerHTML = title.outerHTML + content.outerHTML;

  var currentPosts = document.getElementById("posts").innerHTML;
  var newPosts = newPost.outerHTML + currentPosts;

  document.getElementById("posts").innerHTML = newPosts;
}