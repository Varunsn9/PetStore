package petRepo;

public class Pet {
	 	private int id;
	    private Category category;
	    private String name;
	    private String[] photoUrls;
	    private Tag[] tags;
	    private Status status;
	    
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String[] getPhotoUrls() {
			return photoUrls;
		}
		public void setPhotoUrls(String[] photoUrls) {
			this.photoUrls = photoUrls;
		}
		public Tag getTags() {
			return tags[1];
		}
		public void setTags(Tag[] tags) {
			this.tags = tags;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public Pet() {
	    	Category c=new Category(101,"lamb");
	    	String[] a=new String[] {"abcd.com","xyz.com"} ;
			Tag t=new Tag();
			category=c;
			photoUrls=a;
			tags=new Tag[]{t.id,t.name};
	    }
	    public Pet(int id, String name, Status status) {
	    	this();
	    	this.id=id;
	    	this.name=name;
	    	this.status=status;
	    }
	    
}
