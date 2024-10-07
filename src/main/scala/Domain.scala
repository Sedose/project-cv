import java.time.LocalDate

case class ContactInfo(
  name: String,
  phone: String,
  email: String,
  leetcode: String,
  linkedin: Option[String],
  website: Option[String],
  github: String,
)

case class Experience(
  role: String,
  company: String,
  location: String,
  startDate: LocalDate,
  endDate: Option[LocalDate],
  responsibilities: List[String],
)

case class Education(
  degree: String,
  field: String,
  university: String,
  location: String,
  startDate: LocalDate,
  endDate: String,
)

case class Certification(
  title: String,
  organization: String,
  date: LocalDate,
)

case class SkillSet(
  programmingLanguages: List[String],
  tools: List[String],
  cloudTechnologies: List[String],
  testingFrameworks: List[String],
  platforms: List[String],
  methodologies: List[String],
  languages: List[String],
)

case class Project(
  title: String,
  description: String,
  technologies: List[String],
  link: Option[String],
)

case class Mentorship(
  program: String,
  description: String,
  startDate: LocalDate,
  endDate: Option[LocalDate],
)

case class Award(
  title: String,
  description: String,
  date: LocalDate,
)

case class Resume(
  contact: ContactInfo,
  profile: Option[String], // For optional career summary
  experience: List[Experience],
  education: List[Education],
  skills: SkillSet,
  certifications: List[Certification],
  projects: List[Project],
  mentorships: List[Mentorship],
  awards: List[Award],
)
