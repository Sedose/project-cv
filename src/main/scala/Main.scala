import scalatags.Text.all.*

import java.io.{File, FileWriter}
import scala.util.Using

@main
def main(): Unit =
  Using (new FileWriter(new File("result.html"))) { fileWriter =>
    fileWriter.write(htmlResult)
  }

val htmlResult: String = html(
  head(
    script("some script")
  ),
  body(
    h1(style := "text-align: center;", s"${resume.contact.name}"),
    div(
      p(style := "text-align: center;", s"${resume.contact.phone} | ${resume.contact.email} | ${resume.contact.leetcode} | ${resume.contact.github}"),
      resume.contact.linkedin.map(link => p(s"LinkedIn: $link")).getOrElse(span()),
      resume.contact.website.map(site => p(s"Website: $site")).getOrElse(span()),
    ),
    h2("Profile"),
    resume.profile.map(profile => div(p(profile))).getOrElse(span()),
    h2("Experience"),
    for experience <- resume.experience yield {
      div(
        h3(s"${experience.role} at ${experience.company}"),
        p(s"Location: ${experience.location}"),
        p(s"From: ${experience.startDate} To: ${experience.endDate.getOrElse("Present")}"),
        ul(for responsibility <- experience.responsibilities yield li(responsibility))
      )
    },
    h2("Education"),
    for education <- resume.education yield {
      div(
        h3(s"${education.degree} in ${education.field}"),
        p(s"University: ${education.university}, ${education.location}"),
        p(s"From: ${education.startDate} To: ${education.endDate}")
      )
    },
    h2("Skills"),
    div(
      h3("Programming Languages"),
      ul(for language <- resume.skills.programmingLanguages yield li(language)),
      h3("Tools"),
      ul(for tool <- resume.skills.tools yield li(tool)),
      h3("Cloud Technologies"),
      ul(for cloudTechnology <- resume.skills.cloudTechnologies yield li(cloudTechnology)),
      h3("Testing Frameworks"),
      ul(for testingFramework <- resume.skills.testingFrameworks yield li(testingFramework)),
      h3("Platforms"),
      ul(for platform <- resume.skills.platforms yield li(platform)),
      h3("Methodologies"),
      ul(for methodology <- resume.skills.methodologies yield li(methodology)),
      h3("Languages"),
      ul(for language <- resume.skills.languages yield li(language))
    ),
    h2("Certifications"),
    for certification <- resume.certifications yield {
      div(
        h3(s"${certification.title}"),
        p(s"Organization: ${certification.organization}"),
        p(s"Date: ${certification.date}")
      )
    },
    h2("Projects"),
    for project <- resume.projects yield {
      div(
        h3(s"${project.title}"),
        p(s"${project.description}"),
        ul(for technology <- project.technologies yield li(technology)),
      )
    }
  )
).toString
